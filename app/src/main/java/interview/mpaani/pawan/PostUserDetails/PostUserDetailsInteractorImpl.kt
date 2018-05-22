package interview.mpaani.pawan.PostUserDetails

import interview.mpaani.pawan.Posts.PostDataDO

class PostUserDetailsInteractorImpl : PostUserDetailsInteractor {


    //Medium priority NON-UI variables goes below.....



    //Least priority variables goes below.....
    private val TAG:String = "PostUserDetailsInteractorImpl".toString().substring(0,23)


    override fun getUserDetails(postDataDO: PostDataDO, userDetailsListener: PostUserDetailsInteractor.UserDetailsListener) {



    }//getUserDetails closes here.....

    override fun getAllComments(): List<CommentsDO> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

}//PostUserDetailsInteractorImpl closes here....