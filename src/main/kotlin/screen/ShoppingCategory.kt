package screen

import extensions.getNotEmptyString

/*
  1.화면 이동을 관리하는 stack
  2.장바구니 이전화면 이동 구현
    */
class ShoppingCategory: Screen() {

    fun showcategories() {
        ScreenStack.push(this)
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
                val ShoppingProductList = ShoppingProductList(selectedCategory)
                ShoppingProductList.showProducts()
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