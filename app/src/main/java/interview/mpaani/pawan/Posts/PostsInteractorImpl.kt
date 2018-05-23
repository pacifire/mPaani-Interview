package interview.mpaani.pawan.Posts

import android.util.Log
import com.github.kittinunf.fuel.Fuel
import com.github.kittinunf.fuel.core.Request
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import interview.mpaani.pawan.utils.AppConstants
import org.json.JSONObject

class PostsInteractorImpl : PostsInteractor{


    //Medium priority NON-UI variables goes below......



    //Least prioriy variables goes below.....
    private val TAG:String = "PostsInteractorImpl"



    override fun getPostsArray(postLoadListener: PostsInteractor.OnPostLoadListener) {


        Fuel.get(AppConstants.BASE_URL+AppConstants.POSTS_URL).responseString { request, response, result ->
            //do something with response
            result.fold({ data ->
                //Lets parse the JSON Array here....
                val postsData: List<PostDataDO> = Gson().fromJson(data.toString().trim() , Array<PostDataDO>::class.java).toList()
                postLoadListener.postsLoadSuccess(postsData)
            }, { err ->
                //do something with error
                postLoadListener.postsLoadFailure(POSTS_ERROR_CODES_ENUM.POSTS_NOT_AVAILIABLE)
            })
        }//Fuel.get closes here.....

    }//getPostsArray closes here.....



}//PostsInteractorImpl closes here....