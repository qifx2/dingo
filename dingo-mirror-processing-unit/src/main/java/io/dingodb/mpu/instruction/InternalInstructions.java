/*
 * Copyright 2021 DataCanvas
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package io.dingodb.mpu.instruction;

import io.dingodb.common.codec.ProtostuffCodec;
import io.dingodb.mpu.core.Core;

import java.util.function.Function;

public class InternalInstructions implements Instructions {

    public static final byte id = 1;
    public static final int SIZE = 16;

    public static final int DESTROY_OC = 0;

    private static final Instructions.Processor[] processors = new Instructions.Processor[SIZE];

    private static final Function<byte[], Object[]>[] decoders = new Function[SIZE];

    @Override
    public void processor(int opcode, Processor processor) {
        throw new UnsupportedOperationException();
    }

    @Override
    public Processor processor(int opcode) {
        return processors[opcode];
    }

    @Override
    public void decoder(int opcode, Function<byte[], Object[]> decoder) {
        throw new UnsupportedOperationException();
    }

    @Override
    public Function<byte[], Object[]> decoder(int opcode) {
        return decoders[opcode];
    }

    public static void process(Core core, int opcode, Object... operand) {
        switch (opcode) {
            case DESTROY_OC: {
                core.close();
                core.storage.destroy();
                break;
            }
            default:
                throw new IllegalStateException("Unexpected value: " + operand);
        }
    }

}
