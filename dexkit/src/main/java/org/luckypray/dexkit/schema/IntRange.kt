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
class IntRange : Table() {

    fun __init(_i: Int, _bb: ByteBuffer)  {
        __reset(_i, _bb)
    }
    fun __assign(_i: Int, _bb: ByteBuffer) : IntRange {
        __init(_i, _bb)
        return this
    }
    val min : Int
        get() {
            val o = __offset(4)
            return if(o != 0) bb.getInt(o + bb_pos) else 0
        }
    val end : Int
        get() {
            val o = __offset(6)
            return if(o != 0) bb.getInt(o + bb_pos) else 0
        }
    companion object {
        fun validateVersion() = Constants.FLATBUFFERS_23_5_26()
        fun getRootAsIntRange(_bb: ByteBuffer): IntRange = getRootAsIntRange(_bb, IntRange())
        fun getRootAsIntRange(_bb: ByteBuffer, obj: IntRange): IntRange {
            _bb.order(ByteOrder.LITTLE_ENDIAN)
            return (obj.__assign(_bb.getInt(_bb.position()) + _bb.position(), _bb))
        }
        fun createIntRange(builder: FlatBufferBuilder, min: Int, end: Int) : Int {
            builder.startTable(2)
            addEnd(builder, end)
            addMin(builder, min)
            return endIntRange(builder)
        }
        fun startIntRange(builder: FlatBufferBuilder) = builder.startTable(2)
        fun addMin(builder: FlatBufferBuilder, min: Int) = builder.addInt(0, min, 0)
        fun addEnd(builder: FlatBufferBuilder, end: Int) = builder.addInt(1, end, 0)
        fun endIntRange(builder: FlatBufferBuilder) : Int {
            val o = builder.endTable()
            return o
        }
    }
}
