# 🐶Paws & Names🐱
> _**This project is based on data provided by [NYC Open Data](https://opendata.cityofnewyork.us/)**_
- Website: https://paws-and-names.fly.dev/

## 프로젝트 소개
**Paws & Names**는 뉴욕시(NYC)에서 제공하는 데이터를 기반으로 미국의 인기 반려동물 이름 랭킹과 성별에 따라 랜덤으로 이름을 생성해주는 기능을 제공하는 웹 사이트입니다.

반려동물 이름에 대한 관심이 높아지고 있지만, 실제로 신뢰성 있는 인기 반려동물 이름 랭킹을 쉽게 확인할 수 없다는 점에 주목하여 이 프로젝트를 시작하게 되었습니다. 특히, SQLite를 활용해 데이터를 처리하며 데이터 기반의 신뢰도 높은 이름 추천 서비스를 제공하는 것을 목표로 했습니다.

## 💻 개발 환경

- **IntelliJ Ultimate**
- **JDK 17**
- **Spring Boot 3.3.2**
- **SQLite 3.25.2**
- **Maven**

## 🛠️ 기술 스택

#### **Languages**
![Java](https://img.shields.io/badge/java-%23ED8B00.svg?style=for-the-badge&logo=openjdk&logoColor=white)
![Python](https://img.shields.io/badge/Python-3776AB?style=for-the-badge&logo=python&logoColor=white)

#### **Frameworks & Libraries**
![Spring Boot](https://img.shields.io/badge/Spring_Boot-6DB33F?style=for-the-badge&logo=spring-boot&logoColor=white)
![Spring](https://img.shields.io/badge/Spring-6DB33F?style=for-the-badge&logo=spring&logoColor=white)
![Lombok](https://img.shields.io/badge/Lombok-2A2A2A?style=for-the-badge&logo=lombok&logoColor=white)
![JPA](https://img.shields.io/badge/JPA-2A2A2A?style=for-the-badge&logoColor=white)

#### **Databases & Storage**
![SQLite](https://img.shields.io/badge/sqlite-%2307405e.svg?style=for-the-badge&logo=sqlite&logoColor=white)

#### **Deploy**
![Fly.io](https://img.shields.io/badge/Fly.io-%230db7ed.svg?style=for-the-badge&logo=fly&logoColor=white)
![Docker](https://img.shields.io/badge/docker-%230db7ed.svg?style=for-the-badge&logo=docker&logoColor=white)

## 주요 기능 및 페이지 소개

### 1. 메인 페이지 `Main Page`

#### `TOP 30 RANKING`
![스크린샷 2024-08-19 152440](https://github.com/user-attachments/assets/29c27880-ea74-45fc-a97e-5bae9209921d)

메인 페이지에서는 뉴욕시의 데이터를 기반으로 한 인기 반려동물 이름 랭킹을 `TOP 30 RANKING` 형태로 제공합니다.

#### `Pagination`
![스크린샷 2024-08-19 152615](https://github.com/user-attachments/assets/d2a0db53-391b-4992-83bb-e0a7d0c2b31c)
하단의 `[Load More]` 버튼을 통해 페이지네이션 기능이 작동하며, 추가 데이터를 불러와 사용자에게 더욱 풍부한 정보를 제공합니다.

#### `Filtering`
![스크린샷 2024-08-19 144311](https://github.com/user-attachments/assets/5bea8d80-8d63-4081-ace5-229508d103be)
페이지 상단의 성별 필터(`All`, `Male`, `Female`)를 통해 원하는 성별에 맞춘 반려동물 이름을 필터링하여 볼 수 있습니다.

### 2. 랜덤 이름 생성 페이지 `Random Pet Name Generator`

![PawsAndNames](https://github.com/user-attachments/assets/552beb70-1ede-4a87-afaf-26888d1807ce)

이 페이지에서는 클릭 한 번으로 반려동물의 이름을 추천받을 수 있습니다. `Male`, `Female` 버튼을 눌러 성별에 맞춘 이름을 랜덤으로 생성할 수 있습니다.

![스크린샷 2024-08-19 153925](https://github.com/user-attachments/assets/a0e6c301-daa6-4469-af49-6b77357b6590)

---

## 기술적 도전과 해결 방법
이 프로젝트에서는 Spring Boot와 SQLite를 사용하면서 대용량 데이터를 효율적으로 처리하는 것이 주요 과제였습니다. 성능을 최적화하기 위해 효율적인 쿼리 작성과 페이지네이션을 통해 성능 이슈를 해결했습니다. 또한, Fly.io를 이용한 배포 과정에서도 안정적인 서비스를 제공하기 위해 Docker를 활용한 컨테이너 배포를 적용했습니다.

## 배운 점 및 향후 계획
이 프로젝트를 통해 Spring Boot와 SQLite의 통합, 데이터 처리 최적화 방법, Fly.io를 활용한 배포 과정 등을 익힐 수 있었습니다. 앞으로는 더 다양한 필터링 옵션을 제공하고, 사용자 맞춤형 이름 추천 알고리즘을 구현하여 서비스의 기능성을 더욱 향상시킬 계획입니다.
