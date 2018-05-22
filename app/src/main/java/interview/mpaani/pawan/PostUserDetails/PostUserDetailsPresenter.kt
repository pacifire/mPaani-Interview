package interview.mpaani.pawan.PostUserDetails

import interview.mpaani.pawan.Posts.PostDataDO
import interview.mpaani.pawan.abstracts.BasePresenter

interface PostUserDetailsPresenter : BasePresenter{

    fun setPostsData(postDataDO: PostDataDO)

}//PostUserDetailsPresenter closes here....