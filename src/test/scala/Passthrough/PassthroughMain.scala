// Module 2.1: Your First Chisel Module

package firstModule

import chisel3._
import chisel3.util._
import chisel3.iotesters.{ChiselFlatSpec, Driver, PeekPokeTester}

object PassthroughMain extends App {
    val testResult = Driver(() => new Passthrough()) {
    c => new PeekPokeTester(c) {
      poke(c.io.in, 0)     // Set our input to value 0
      expect(c.io.out, 0)  // Assert that the output correctly has 0
      poke(c.io.in, 1)     // Set our input to value 1
      expect(c.io.out, 1)  // Assert that the output correctly has 1
      poke(c.io.in, 2)     // Set our input to value 2
      expect(c.io.out, 2)  // Assert that the output correctly has 2
    }
  }
  assert(testResult)   // Scala Code: if testResult == false, will throw an error
  println("SUCCESS!!") // Scala Code: if we get here, our tests passed!

  // println(getVerilog(new Passthrough))
  // println(Driver.emitVerilog(new Passthrough))
  // chisel3.Driver.execute(args, () => new Passthrough)
}
