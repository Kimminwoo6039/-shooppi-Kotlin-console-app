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

    private fun extracted(){
        val ShoppingCategory = ShoppingCategory()
        ShoppingCategory.showcategories() //ㄷ
    }

}