package ir.rahmani.githubproject.nav

sealed class Screen(val route:String){

    object Splash:Screen("splash_screen")
    object MainScreen:Screen("main_screen")
    object DetailScreen:Screen("detail_screen")
    object FavScreen:Screen("favorite_screen")


    fun withArgs(vararg args:String):String= buildString {
        append(route)
        args.forEach {args->
            append("/$args")
        }
    }
}
