# tripleclub

## API
* 리뷰작성 이벤트 등록 수정 삭제
  * POST /events
  * {
    "type": "REVIEW",
    "action": "ADD", /* "MOD", "DELETE" */
    "reviewId": "240a0658-dc5f-4878-9381-ebb7b2667772",
    "content": "좋아요!",
    "attachedPhotoIds": ["e4d1a64e-a531-46de-88d0-ff0ed70c0bb8", "afb0cef2-
    851d-4a50-bb07-9cc15cbdc332"],
    "userId": "3ede0ef2-92b7-4817-a5f3-0c575361f745",
    "placeId": "2e4baf1c-5acb-4efb-a1af-eddada31b00f"
    }
* 유저 포인터 적립 조회
  * GET /users/3ede0ef2-92b7-4817-a5f3-0c575361f745

## To to List
* POST API Events로 받기
* 리뷰 등록 API
* 리뷰 수정 API
* 리뷰 삭제 API
* 1자 이상의 텍스트 작성 1점
* 1장 이상의 사진 첨부 1점
* 특정 장소 첫 리뷰 1점
  * 어떤 장소에 사용자 A가 리뷰를 남겼다가 삭제하고, 삭제된 이후 사용자 B가 리뷰를 남기면 사용자 B에게 보너스 점수를 부여합니다.
  * 어떤 장소에 사용자 A가 리뷰를 남겼다가 삭제하는데, 삭제되기 이전 사용자 B가 리뷰를 남기면 사용자 B에게 보너스 점수를 부여하지 않습니다.
* 리뷰 수정시 요건에 따라 점수 수정.
* 현재 포인트 총점 조회 API

### Remark
* 포인트 증감 이력 필요
* 전체 스캔을 타지 않는 인덱스

### ERD
![image](https://user-images.githubusercontent.com/32088584/177117177-6f780f55-db87-45a9-b22c-f20a44d3be97.png)
https://www.erdcloud.com/d/GFjkDnePsAAabjiTH
