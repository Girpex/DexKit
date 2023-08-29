@file:Suppress("MemberVisibilityCanBePrivate", "unused", "INVISIBLE_REFERENCE", "INVISIBLE_MEMBER")

package org.luckypray.dexkit.query

import com.google.flatbuffers.FlatBufferBuilder
import org.luckypray.dexkit.InnerFindMethod
import org.luckypray.dexkit.query.base.BaseQuery
import org.luckypray.dexkit.query.matchers.MethodMatcher
import org.luckypray.dexkit.result.ClassData
import org.luckypray.dexkit.result.MethodData

class FindMethod : BaseQuery() {
    private var searchPackages: List<String>? = null
    private var excludePackages: List<String>? = null
    @set:JvmSynthetic
    var ignorePackagesCase: Boolean = false
    private var searchClasses: LongArray? = null
    private var searchMethods: LongArray? = null
    private var matcher: MethodMatcher? = null

    fun searchPackages(vararg searchPackages: String) = also {
        this.searchPackages = searchPackages.toList()
    }

    fun searchPackages(searchPackages: List<String>) = also {
        this.searchPackages = searchPackages
    }

    fun excludePackages(vararg excludePackages: String) = also {
        this.excludePackages = excludePackages.toList()
    }

    fun excludePackages(excludePackages: List<String>) = also {
        this.excludePackages = excludePackages
    }

    fun ignorePackagesCase(ignorePackagesCase: Boolean) = also {
        this.ignorePackagesCase = ignorePackagesCase
    }

    fun searchInClass(classList: List<ClassData>) = also {
        this.searchClasses = classList.map { getEncodeId(it.dexId, it.id) }.toLongArray()
    }

    fun searchInMethod(methodList: List<MethodData>) = also {
        this.searchMethods = methodList.map { getEncodeId(it.dexId, it.id) }.toLongArray()
    }
    fun matcher(matcher: MethodMatcher) = also {
        this.matcher = matcher
    }

    // region DSL

    @kotlin.internal.InlineOnly
    inline fun FindMethod.matcher(init: MethodMatcher.() -> Unit) = also {
        matcher(MethodMatcher().apply(init))
    }

    // endregion

    companion object {
        @JvmStatic
        fun create() = FindMethod()
    }
    
    override fun innerBuild(fbb: FlatBufferBuilder): Int {
        val root = InnerFindMethod.createFindMethod(
            fbb,
            searchPackages?.map { fbb.createString(it) }?.let { fbb.createVectorOfTables(it.toIntArray()) } ?: 0,
            excludePackages?.map { fbb.createString(it) }?.let { fbb.createVectorOfTables(it.toIntArray()) } ?: 0,
            ignorePackagesCase,
            searchClasses?.let { InnerFindMethod.createInClassesVector(fbb, it) } ?: 0,
            searchMethods?.let { InnerFindMethod.createInMethodsVector(fbb, it) } ?: 0,
            matcher?.build(fbb) ?: 0
        )
        fbb.finish(root)
        return root
    }
}
