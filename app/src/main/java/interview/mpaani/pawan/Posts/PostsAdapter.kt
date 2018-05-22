package interview.mpaani.pawan.Posts

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.ContextMenu
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import interview.mpaani.pawan.R
import interview.mpaani.pawan.R.id.postsTitleTxtV
import kotlinx.android.synthetic.main.single_row_posts.view.*

class PostsAdapter(context: Context, postsDataList:List<PostDataDO>) : RecyclerView.Adapter<PostsAdapter.ViewHolder>() {

    //Medium priority NON-UI variables goes below.....
    private lateinit var mContext: Context;
    private lateinit var mPostsDataList: List<PostDataDO>



    //Least priority variables goes below.....
    private val TAG:String = "PostsAdapter"


    init {
        mContext = context
        mPostsDataList = postsDataList
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostsAdapter.ViewHolder{

        val view = LayoutInflater.from(mContext).inflate(R.layout.single_row_posts, parent, false)

        return ViewHolder(view)
    }//onCreateViewHolder closes here.....

    override fun getItemCount(): Int {
        return mPostsDataList.size
    }//getItemCount closes here.....

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.itemView.postsTitleTxtV.setText(mPostsDataList[position].title.toString().trim())
        holder.itemView.postsDescTxtV.setText((mPostsDataList[position].body.toString().trim()))

    }//onBindViewHolder closes here.....


    class ViewHolder(itemView: View?) : RecyclerView.ViewHolder(itemView) {

    }//ViewHolder class closes here.....
}//PostsAdapter closes here.....