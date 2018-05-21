package interview.mpaani.pawan.Posts

import interview.mpaani.pawan.abstracts.BaseView

interface PostsView : BaseView{


    fun setPostsAdapter()

    fun appendPostsToView()

    fun noPostsFound(errorMsg:String)

}//PostsView closes here....