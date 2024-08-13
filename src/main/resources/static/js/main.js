document.addEventListener('DOMContentLoaded', function() {
    let page = 0;
    let loading = false;

    function loadPets() {
        if (loading) return;
        loading = true;
        document.getElementById('loading').style.display = 'block';

        fetch(`/pets?page=${page}&size=100`)
            .then(response => response.json())
            .then(data => {
                const tbody = document.getElementById('petTableBody');
                data.content.forEach((pet, index) => {
                    const tr = document.createElement('tr');
                    tr.innerHTML = `
                        <td>${page * 100 + index + 1}</td>
                        <td>${pet.animalName} (${pet.animalGender})</td>
                        <td>${pet.nameCount}</td>
                    `;
                    tbody.appendChild(tr);
                });

                loading = false;
                document.getElementById('loading').style.display = 'none';
                if (data.last) {
                    window.removeEventListener('scroll', handleScroll);
                }
            });
    }

    function handleScroll() {
        if (window.innerHeight + window.scrollY >= document.documentElement.scrollHeight) {
            page++;
            loadPets();
        }
    }

    window.addEventListener('scroll', handleScroll);
    loadPets();
});
