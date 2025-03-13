package com.back


import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.ResponseBody
import org.springframework.web.bind.annotation.RestController
import software.amazon.awssdk.services.s3.S3Client


@RestController
class HomeController(
    private val s3Client: S3Client
) {
    @GetMapping("/s3-ls")
    @ResponseBody
    fun listAllBuckets(): List<String> {
        return s3Client.listBuckets().buckets().map { it.name() }
    }
}