package uz.context.twitter_app

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import uz.context.twitter_app.adapter.FeedAdapter
import uz.context.twitter_app.adapter.StoryAdapter
import uz.context.twitter_app.model.Post
import uz.context.twitter_app.model.Story

class MainActivity : AppCompatActivity() {
    private lateinit var recyclerStory: RecyclerView
    private lateinit var recyclerFeed: RecyclerView
    private val posts: ArrayList<Post> = ArrayList()
    private val stories: ArrayList<Story> = ArrayList()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initViews()
    }

    private fun initViews() {
        recyclerFeed = findViewById(R.id.recyclerFeed)
        recyclerStory = findViewById(R.id.recyclerStory)
        recyclerFeed.layoutManager = GridLayoutManager(this, 1)
        recyclerStory.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)

        refreshStoryAdapter(getAllStories())
        refreshFeedAdapter(getAllFeeds())
    }

    private fun refreshStoryAdapter(chats: ArrayList<Story>) {
        val adapter = StoryAdapter(this, chats)
        recyclerStory.adapter = adapter
    }

    private fun refreshFeedAdapter(posts: ArrayList<Post>) {
        val adapter = FeedAdapter(this, posts)
        recyclerFeed.adapter = adapter
    }

    private fun getAllStories(): ArrayList<Story> {
        for (i in 0..30) {
            stories.add(Story(R.drawable.img_android, "Android"))
        }
        return stories
    }

    private fun getAllFeeds(): ArrayList<Post> {
        for (i in 0..40) {
            posts.add(Post(R.drawable.img_android, "Android", R.drawable.img_android))
        }
        return posts
    }
}