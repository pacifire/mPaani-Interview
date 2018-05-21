package interview.mpaani.pawan.Posts

interface PostsInteractor {

    interface OnPostLoadListener{

        fun postsLoadSuccess()

        fun postsLoadFailure()

    }//OnPostLoadListener closes here.....

}//PostsInteractor closes here....