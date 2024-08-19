let page = 0;
let isLoading = false;
let genderFilterValue = ''; // 초기 상태는 모든 성별

function loadMorePets() {
    if (isLoading) return;
    isLoading = true;

    document.getElementById('loading').style.display = 'block';

    // 성별 필터가 있는 경우와 없는 경우에 따라 URL 변경
    const url = genderFilterValue
        ? `/pets/gender?animalGender=${encodeURIComponent(genderFilterValue)}&page=${page}&size=30`
        : `/pets?page=${page}&size=30`;

    fetch(url)
        .then(response => response.json())
        .then(data => {
            const rankingList = document.getElementById('ranking-list');
            data.content.forEach(pet => {
                const rankingItem = document.createElement('div');
                rankingItem.className = 'ranking-item';

                const rank = document.createElement('div');
                rank.className = 'rank';
                rank.textContent = rankingList.children.length + 1;

                const gender = document.createElement('div');
                gender.className = `gender ${pet.animalGender === 'M' ? 'male' : 'female'}`;
                gender.textContent = pet.animalGender === 'M' ? '♂' : '♀';

                const name = document.createElement('div');
                name.className = 'name';
                name.textContent = pet.animalName || 'No Name';

                rankingItem.appendChild(rank);
                rankingItem.appendChild(gender);
                rankingItem.appendChild(name);

                rankingList.appendChild(rankingItem);
            });

            document.getElementById('loading').style.display = 'none';
            isLoading = false;

            if (!data.last) {
                page++;
            } else {
                document.getElementById('load-more-btn').style.display = 'none'; // 마지막 페이지면 버튼 숨기기
            }
        })
        .catch(error => {
            console.error('Error fetching pet data:', error);
            document.getElementById('loading').style.display = 'none';
            isLoading = false;
        });
}

// 성별 필터를 적용하는 함수
function applyFilter(gender) {
    genderFilterValue = gender === 'all' ? '' : gender; // 'all'은 필터를 제거하는 역할
    page = 0; // 페이지를 초기화
    document.getElementById('ranking-list').innerHTML = ''; // 기존 데이터 제거
    loadMorePets(); // 새로운 데이터 로드
}

// 초기 로드
window.addEventListener('DOMContentLoaded', () => {
    loadMorePets(); // 페이지 로드 시 데이터 로드

    // 버튼 클릭 이벤트 리스너
    document.getElementById('allButton').addEventListener('click', () => applyFilter('all'));
    document.getElementById('maleButton').addEventListener('click', () => applyFilter('M'));
    document.getElementById('femaleButton').addEventListener('click', () => applyFilter('F'));

    // 'Load More' 버튼 클릭 이벤트 리스너
    document.getElementById('load-more-btn').addEventListener('click', loadMorePets);
});
