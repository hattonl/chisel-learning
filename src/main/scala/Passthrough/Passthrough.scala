// Module 2.1: Your First Chisel Module

package firstModule

import chisel3._
import chisel3.util._
import chisel3.iotesters.{ChiselFlatSpec, Driver, PeekPokeTester}

// Chisel Code: Declare a new module definition
class Passthrough extends Module {
  val io = IO(new Bundle {
    val in = Input(UInt(4.W))
    val out = Output(UInt(4.W))
  })
  io.out := io.in
}

object Passthrough extends App {
  chisel3.Driver.execute(args, () => new Passthrough)
}