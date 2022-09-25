package screen

object ScreenStack {
    private val screenStack = mutableListOf<Screen>()

    fun push(screen :Screen){
        screenStack.add(screen)
    }

    fun pop(){
        screenStack.removeLastOrNull() // 상단에 최신꺼 삭제
    }

    fun peek(): Screen? {
        return screenStack.lastOrNull() // 값이 없을때 null 로 반환해서 오류 발생 x
    }
}

sealed class Screen