import pandas as pd
import sqlite3
import shutil

# Path to the CSV file
file_path = 'C:/Users/OJ/Downloads/NYC_Dog_Dataset.csv'

# Load the CSV file
df = pd.read_csv(file_path)

# Extract the specified columns
df_selected = df[['AnimalName', 'AnimalGender', 'AnimalBirthYear', 'BreedName']]

# Add a 'NameCount' column
df_selected['NameCount'] = df_selected.groupby('AnimalName').AnimalName.transform('count')

# Add an 'Id' column
df_selected.reset_index(drop=True, inplace=True)
df_selected['Id'] = df_selected.index + 1

# Rename columns to match the SQLite table schema
df_selected.rename(columns={
    'AnimalName': 'animal_name',
    'AnimalGender': 'animal_gender',
    'AnimalBirthYear': 'animal_birth_year',
    'BreedName': 'breed_name'
}, inplace=True)

# Connect to SQLite database (it will create a new database if it doesn't exist)
conn = sqlite3.connect('pets_database.db')
cursor = conn.cursor()

# Create a new SQLite table with an 'Id' column
cursor.execute('''
CREATE TABLE IF NOT EXISTS pets (
    Id INTEGER PRIMARY KEY,
    animal_name TEXT,
    animal_gender TEXT,
    animal_birth_year INTEGER,
    breed_name TEXT,
    name_count INTEGER
)
''')

# Insert DataFrame into SQLite table
df_selected.to_sql('pets', conn, if_exists='replace', index=False)

# Commit and close the connection
conn.commit()
conn.close()

# Display the DataFrame
print(df_selected)

# Connect to SQLite database
conn = sqlite3.connect('pets_database.db')

# Query the data from the SQLite table
df_export = pd.read_sql_query('SELECT * FROM pets', conn)

# Export the DataFrame to CSV
export_file_path = 'C:/Users/OJ/Downloads/pets_export.csv'
df_export.to_csv(export_file_path, index=False)

# Close the connection
conn.close()

print(f"Data exported successfully to {export_file_path}")

# Define the path to the existing SQLite database
source_db_path = 'pets_database.db'

# Define the path to the new location where you want to export or move the database
destination_db_path = 'C:/Users/OJ/Downloads/pets_database_exported.db'

# Copy the SQLite database file to the new location
shutil.copy(source_db_path, destination_db_path)

print(f"Database exported successfully to {destination_db_path}")
