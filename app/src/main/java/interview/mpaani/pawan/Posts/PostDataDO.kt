package interview.mpaani.pawan.Posts

import com.github.kittinunf.fuel.core.ResponseDeserializable
import com.google.gson.Gson

class PostDataDO {

    var userId:Long? = null//Dont trust Backend Dev :(P)
    var id:Long? = null//Dont trust Backend Dev :(P) (This is the ID of the post)
    var title:String? = null//This is the title of the post.
    var body:String? = null//This is the Body of the post.

}//PostDataDO closes here....