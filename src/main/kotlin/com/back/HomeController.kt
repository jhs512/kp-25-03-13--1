package com.back

import com.amazonaws.services.s3.AmazonS3ClientBuilder
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.ResponseBody
import org.springframework.web.bind.annotation.RestController

@RestController
class HomeController {
    @GetMapping("/s3-ls")
    @ResponseBody
    fun home(): List<String> {
        val s3Client = AmazonS3ClientBuilder.defaultClient()
        return s3Client.listBuckets().map { it.name }
    }
}