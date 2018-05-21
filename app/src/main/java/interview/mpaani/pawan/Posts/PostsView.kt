package interview.mpaani.pawan.Posts

import interview.mpaani.pawan.abstracts.BaseView

interface PostsView : BaseView{


    fun setPostsAdapter(postsData: List<PostDataDO>)

    fun appendPostsToView()

    fun noPostsFound(errorMsg:String)

}//PostsView closes here....