package com.example.shoppinglist

class ResourceState(val status: ResourceStatus, val data: Any?, val message: String?) {
    companion object {
        fun success(data: Any?, message: String?) =
            ResourceState(status = ResourceStatus.SUCCESS, data = data, message = message)

        fun fail(message: String?) =
            ResourceState(status = ResourceStatus.FAIL, data = null, message = message)

        fun loading() = ResourceState(status = ResourceStatus.LOADING, data = null, message = null)
    }
}