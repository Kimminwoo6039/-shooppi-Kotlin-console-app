package screen

import LINE_DIVIDER
import data.CartItems
import data.Product // 임포트 시킴!
import extensions.getNotEmptyInt
import extensions.getNotEmptyString
import screen.ShoppingCategory
class ShoppingProductList(private val selectedCategory: String) : Screen() { // 관리

    private val products = arrayOf(
        Product(categoryLable = "패션", naem = "겨울패딩") ,
        Product(categoryLable = "패션", naem = "겨울바지"),
        Product(categoryLable = "전자기기", naem = "핸드폰"),
        Product(categoryLable = "전자기기", naem = "블루투스 이어폰"),
        Product(categoryLable = "전자기기", naem = "노트북"),
        Product(categoryLable = "반려동물용품", naem = "건식사료"),
        Product(categoryLable = "반려동물용품", naem = "습식사료"),
        Product(categoryLable = "반려동물용품", naem = "치약"),
        Product(categoryLable = "반려동물용품", naem = "간식"),

        )

    private val categories: Map<String,List<Product>> = products.groupBy { product ->
        product.categoryLable
    }
    //카테고리즈라는 변수 선언 하고  Map < key, valyue > 값을 = 상품들중에 그륩별로 카테고리레이블로


    fun showProducts(){
        ScreenStack.push(this)
        val categoryProducts = categories[selectedCategory]
        if(!categoryProducts.isNullOrEmpty()){

            println("""
               $LINE_DIVIDER
               선택하신 [$selectedCategory] 카테고리 상품입니다
            """.trimIndent())
           /* val productSize = categoryProducts.size
            for(index in 0  until  productSize) {
                println("${index}. ${categoryProducts[index].naem}")
            }*/
              categoryProducts.forEachIndexed { index, product ->  println("${index}. ${categoryProducts[index].naem}")}
              showCartOption(categoryProducts)

        }else{
            println("[$selectedCategory] :카테고리 등록전입니다..")

        }



    }


    private fun showCartOption(categoryProducts : List<Product>){
        println("""
            $LINE_DIVIDER
            장바구니에 담을 상품 번호를 선택해주세요
        """.trimIndent()
        )



          // 내가만듬

        val selectedIndex = readLine().getNotEmptyInt()
            if(selectedCategory.length < selectedIndex){ // 개수 !!
                println("다시입력해주세요")
                categoryProducts.forEachIndexed { index, product ->  println("${index}. ${categoryProducts[index].naem}")}
                showCartOption(categoryProducts)
            }

         // 내가만듬

        categoryProducts.getOrNull(selectedIndex)?.let { product ->
           CartItems.addProduct(product)
            println("=>장바구니로 이동하시려면 #을 ,계속하시려면 * 을 입력해주세요")
            val answer = readLine().getNotEmptyString()
            if(answer=="#"){
                val shoppingCart = ShoppingCart()
                shoppingCart.showCartItems()
            }else if(answer=="*"){
                showProducts()
            }else{
                //TODO 그 외 값을 입력한 값 처리
                println("zzzz")
            }
        } ?: kotlin.run {
            println("$selectedIndex 번은 목록에 없는 상품 번호입니다.")
        }





    }









}
