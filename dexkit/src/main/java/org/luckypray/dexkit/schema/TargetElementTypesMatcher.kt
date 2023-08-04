// automatically generated by the FlatBuffers compiler, do not modify

package org.luckypray.dexkit.schema

import com.google.flatbuffers.BaseVector
import com.google.flatbuffers.BooleanVector
import com.google.flatbuffers.ByteVector
import com.google.flatbuffers.Constants
import com.google.flatbuffers.DoubleVector
import com.google.flatbuffers.FlatBufferBuilder
import com.google.flatbuffers.FloatVector
import com.google.flatbuffers.LongVector
import com.google.flatbuffers.StringVector
import com.google.flatbuffers.Struct
import com.google.flatbuffers.Table
import com.google.flatbuffers.UnionVector
import java.nio.ByteBuffer
import java.nio.ByteOrder
import kotlin.math.sign

@Suppress("unused")
class TargetElementTypesMatcher : Table() {

    fun __init(_i: Int, _bb: ByteBuffer)  {
        __reset(_i, _bb)
    }
    fun __assign(_i: Int, _bb: ByteBuffer) : TargetElementTypesMatcher {
        __init(_i, _bb)
        return this
    }
    fun containTypes(j: Int) : Byte {
        val o = __offset(4)
        return if (o != 0) {
            bb.get(__vector(o) + j * 1)
        } else {
            0
        }
    }
    val containTypesLength : Int
        get() {
            val o = __offset(4); return if (o != 0) __vector_len(o) else 0
        }
    val containTypesAsByteBuffer : ByteBuffer get() = __vector_as_bytebuffer(4, 1)
    fun containTypesInByteBuffer(_bb: ByteBuffer) : ByteBuffer = __vector_in_bytebuffer(_bb, 4, 1)
    companion object {
        fun validateVersion() = Constants.FLATBUFFERS_23_5_26()
        fun getRootAsTargetElementTypesMatcher(_bb: ByteBuffer): TargetElementTypesMatcher = getRootAsTargetElementTypesMatcher(_bb, TargetElementTypesMatcher())
        fun getRootAsTargetElementTypesMatcher(_bb: ByteBuffer, obj: TargetElementTypesMatcher): TargetElementTypesMatcher {
            _bb.order(ByteOrder.LITTLE_ENDIAN)
            return (obj.__assign(_bb.getInt(_bb.position()) + _bb.position(), _bb))
        }
        fun createTargetElementTypesMatcher(builder: FlatBufferBuilder, containTypesOffset: Int) : Int {
            builder.startTable(1)
            addContainTypes(builder, containTypesOffset)
            return endTargetElementTypesMatcher(builder)
        }
        fun startTargetElementTypesMatcher(builder: FlatBufferBuilder) = builder.startTable(1)
        fun addContainTypes(builder: FlatBufferBuilder, containTypes: Int) = builder.addOffset(0, containTypes, 0)
        fun createContainTypesVector(builder: FlatBufferBuilder, data: ByteArray) : Int {
            builder.startVector(1, data.size, 1)
            for (i in data.size - 1 downTo 0) {
                builder.addByte(data[i])
            }
            return builder.endVector()
        }
        fun startContainTypesVector(builder: FlatBufferBuilder, numElems: Int) = builder.startVector(1, numElems, 1)
        fun endTargetElementTypesMatcher(builder: FlatBufferBuilder) : Int {
            val o = builder.endTable()
            return o
        }
    }
}