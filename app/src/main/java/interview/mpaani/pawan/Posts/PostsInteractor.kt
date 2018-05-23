package interview.mpaani.pawan.Posts

interface PostsInteractor {


    fun getPostsArray(postLoadListener:OnPostLoadListener)



    interface OnPostLoadListener{

        fun postsLoadSuccess(postsData:List<PostDataDO>)

        fun postsLoadFailure(postErrorCodeEnum:POSTS_ERROR_CODES_ENUM)

    }//OnPostLoadListener closes here.....

}//PostsInteractor closes here....