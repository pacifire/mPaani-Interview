package interview.mpaani.pawan.Posts

import com.github.kittinunf.fuel.core.ResponseDeserializable
import com.google.gson.Gson

open class PostsArrayDO {


    var postsAl:ArrayList<PostDataDO>? = null



//    //Posts Deserializer
//    class Deserializer : ResponseDeserializable<PostsArrayDO> {
//        override fun deserialize(content: String) = Gson().fromJson(content, PostsArrayDO[]::class.java)
//    }


}//PostsArrayDO closes here.....