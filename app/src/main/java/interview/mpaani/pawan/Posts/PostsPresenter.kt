package interview.mpaani.pawan.Posts

import interview.mpaani.pawan.abstracts.BasePresenter

interface PostsPresenter : BasePresenter {

    fun loadPosts(postsLoadedVia:POSTS_LOADED_VIA)

}//PostsPresenter closes here....