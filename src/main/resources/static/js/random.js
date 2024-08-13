document.addEventListener('DOMContentLoaded', function() {
    const form = document.getElementById('randomNameForm');
    const resultDiv = document.getElementById('result');

    form.addEventListener('submit', function(event) {
        event.preventDefault();
        const animalGender = document.getElementById('animalGender').value;

        fetch(`/pets/random?animalGender=${animalGender}`)
            .then(response => response.text())
            .then(data => {
                resultDiv.innerHTML = `<p>Random Name: ${data}</p>`;
            });
    });
});
