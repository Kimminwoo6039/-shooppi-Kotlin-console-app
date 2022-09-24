package screen

import data.Product // 임포트 시킴!
import screen.ShoppingCategory
class ShoppingProductList {

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


    fun showProducts(selectedCategory: String){

        val categoryProducts = categories[selectedCategory]
        if(!categoryProducts.isNullOrEmpty()){

            println("""
               ***============================
               선택하신 [$selectedCategory] 카테고리 상품입니다
            """.trimIndent())
            val productSize = categoryProducts.size
            for(index in 0  until  productSize) {
                println("${index}. ${categoryProducts[index].naem}")
            }

        }else{
            println("[$selectedCategory] :카테고리 등록전입니다.")

        }



    }







}
