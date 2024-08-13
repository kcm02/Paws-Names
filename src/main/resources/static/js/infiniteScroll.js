document.addEventListener('DOMContentLoaded', function() {
    let page = 0;
    let loading = false;
    const container = document.getElementById('petsContainer');
    const loadingIndicator = document.getElementById('loading');

    function loadPets() {
        if (loading) return;
        loading = true;
        loadingIndicator.style.display = 'block';

        fetch(`/pets?page=${page}&size=10`)
            .then(response => response.json())
            .then(data => {
                if (data.length === 0) {
                    window.removeEventListener('scroll', onScroll);
                    loadingIndicator.style.display = 'none';
                    return;
                }

                data.forEach(pet => {
                    const petElement = document.createElement('div');
                    petElement.className = 'pet';
                    petElement.innerHTML = `
                        <h3>${pet.name}</h3>
                        <p>Breed: ${pet.breed}</p>
                        <p>Age: ${pet.age}</p>
                    `;
                    container.appendChild(petElement);
                });

                page++;
                loading = false;
                loadingIndicator.style.display = 'none';
            })
            .catch(error => {
                console.error('Error fetching pets:', error);
                loading = false;
                loadingIndicator.style.display = 'none';
            });
    }

    function onScroll() {
        if (window.innerHeight + window.scrollY >= document.body.offsetHeight) {
            loadPets();
        }
    }

    window.addEventListener('scroll', onScroll);

    // Initial load
    loadPets();
});
