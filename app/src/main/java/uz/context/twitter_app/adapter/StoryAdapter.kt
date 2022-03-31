package uz.context.twitter_app.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.imageview.ShapeableImageView
import uz.context.twitter_app.R
import uz.context.twitter_app.model.Story

class StoryAdapter(
    context: Context,
    private val items: ArrayList<Story>
) : RecyclerView.Adapter<RecyclerView.ViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_feed_story, parent, false)
        return StoryViewHolder(view)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val item = items[position]

        if (holder is StoryViewHolder) {
            holder.apply {
                ivProfile.setImageResource(item.profile)
                tvFullName.text = item.fullName
            }
        }
    }

    override fun getItemCount(): Int {
        return items.size
    }
    class StoryViewHolder(view: View): RecyclerView.ViewHolder(view) {
        val ivProfile: ShapeableImageView = view.findViewById(R.id.iv_profile)
        val tvFullName: TextView = view.findViewById(R.id.tv_fullname)
    }
}