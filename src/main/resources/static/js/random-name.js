function generateName(gender) {
    fetch(`/pets/random?animalGender=${gender}`)
        .then(response => response.text())
        .then(name => {
            document.getElementById('random-name-display').textContent = name;
        });
}
