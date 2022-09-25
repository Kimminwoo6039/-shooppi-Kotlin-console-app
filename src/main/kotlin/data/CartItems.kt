package data

object CartItems {  // 싱글톤 오브젝트

    private val mutableProducts = mutableMapOf<Product,Int>() // map < 상품 , 수량 > 저장 외부에서 수정못하기 private
    val products:Map<Product,Int> = mutableProducts // readonly 만 가능하게 만듬

    fun addProduct(product: Product){  // product 파라미터 : Product 클래스형
        mutableProducts[product]?.let { // key 값인 product 가 null 이 아니면
            mutableProducts[product] = it+1

        } ?: kotlin.run { //처음 장바구니에 넣엇을때 1로 할당해야함 Elves
            mutableProducts[product] = 1
        }
    }
}