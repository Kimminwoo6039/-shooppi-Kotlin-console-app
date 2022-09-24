package screen

class ShoppinHome {

    fun start(){
        extracted1()
        extracted()



    }

    private fun extracted1() {
        println("안녕하세요,shoppi 에 오신걸 환영합니다 ~ ")
        println("쇼핑몰을 계속 하시려면 이름을 입력해주세요 :)")

        val name = readLine() // 콘솔창에 입력해준값을 name 이란 변수에다가 값을 넣어줍니다.
        println(
            """
          감사합니다. 반가워요 $name 님
          원하시는 카테고리를 입력해주세요
          ***=================================
       """.trimIndent()
        )
    }

    private fun extracted() {
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
            //TODO 2..카테고리상품 목록 보여주기
            // TDOD 3..카테고리 목록에 없는 값을 입력하는 경우
        }
    }



}