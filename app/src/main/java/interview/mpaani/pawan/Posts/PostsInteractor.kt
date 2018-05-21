package interview.mpaani.pawan.Posts

interface PostsInteractor {


    fun getPostsArray(postLoadListener:OnPostLoadListener)



    interface OnPostLoadListener{

        fun postsLoadSuccess(postsData:List<PostDataDO>)

        fun postsLoadFailure(postFailureMsg:String)

    }//OnPostLoadListener closes here.....

}//PostsInteractor closes here....