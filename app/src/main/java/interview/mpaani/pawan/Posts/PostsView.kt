package interview.mpaani.pawan.Posts

import interview.mpaani.pawan.abstracts.BaseView

interface PostsView : BaseView{


    fun setPostsAdapter(postsData: List<PostDataDO>)

    fun appendPostsToView()

    fun noPostsFound(postErrorEnum:POSTS_ERROR_CODES_ENUM)

}//PostsView closes here....