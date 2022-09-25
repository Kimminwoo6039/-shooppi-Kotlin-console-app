package screen

import extensions.getNotEmptyString

/*
   1.장바구니에 추가한 상품 관리
   2.사용자 입력값 요청 처리 공통화
   3.프로젝트 전역에서 참조하는 상수

    */
class ShoppingCategory {

    fun showcategories() {
        val categories = arrayOf("패션", "전자기기", "반려동물용품")
        for (category in categories) {
            println(category)
        }

        println("=>장바구니로 이동하시려면 #을 입력해주세요")

        val selectedCategory = readLine().getNotEmptyString()

      /*  while (selectedCategory.isNullOrBlank()) {
            println("값을 입력해주세요")
            selectedCategory = readLine()
        }*/
        if (selectedCategory == "#") {
            val shoppingCart = ShoppingCart() // 쇼핑카트 클래스 생성
            shoppingCart.showCartItems()
        } else {

            if(categories.contains(selectedCategory)){ //카테고리즈 안에 있는 내용을 입력햇을 경우
                val ShoppingProductList = ShoppingProductList()
                ShoppingProductList.showProducts(selectedCategory)
            }else{

                ShowErrorMessage(selectedCategory)
            }

        }
    }

    private fun ShowErrorMessage(selectedCategory: String?) {
        println("[$selectedCategory] : 존재하지 않는 카테고리입니다. 다시입력해주세욧")
        showcategories() // 다시 패션 전자기기 반려동물 용품 보여주세요1
    }


}