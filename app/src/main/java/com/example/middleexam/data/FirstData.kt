package com.example.middleexam.data

import com.example.middleexam.data.Story
import com.example.middleexam.data.TopStory

data class FirstData(
    val date: String,
    val stories: List<Story>,
    val top_stories: List<TopStory>
)