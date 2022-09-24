package screen

class ShoppingCategory {

     fun showcategories() {
        val categories = arrayOf("패션", "전자기기", "반려동물용품")
        for (category in categories) {
            println(category)
        }

        println("=>장바구니로 이동하시려면 #을 입력해주세요")

        var selectedCategory = readLine()

        while (selectedCategory.isNullOrBlank()) {
            println("값을 입력해주세요")
            selectedCategory = readLine()
        }
        if (selectedCategory == "#") {
            // TODO 1..장바구니 이동
        } else {

            if(categories.contains(selectedCategory)){ //카테고리즈 안에 있는 내용을 입력햇을 경우
                // TODO 2..카테고리상품 목록 보여주기
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