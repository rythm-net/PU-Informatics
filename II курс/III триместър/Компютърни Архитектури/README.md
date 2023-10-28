<h2 align="center">Компютърни архитектури</h2>

### [Mind Map](https://mind42.com/public/e22d9527-1e31-4a20-be8b-aa83b21e4ea4)

### TOPIC 1 - История на Компютърните Архитектури/Системи и Операционни Системи. Linux команди.

* [_КСК История_](https://www.youtube.com/watch?v=bwxM9O2Fq5Y)
* [_КСК Команди_](https://www.youtube.com/watch?v=A753p5F_L4g)
* [Mind Map (Modern Operating Systems)](https://mind42.com/public/14a1d418-b4d5-444a-975d-e8b2612775f2)

---

### TOPIC 2 - Хардуер, Процесор, Памет (Hardware, CPU, Memory)

* [_Хардуер, Процесор, Памет_](https://www.youtube.com/watch?v=U74SfqpBPTs)

---

### TOPIC 3 - Hardware: Disks, I/O, Buses, Booting etc. Summary: PROCESSES,THREADS, MEMORY, FILE SYSTEMS, etc.

* [_Хардуер_](https://www.youtube.com/watch?v=vY-QPVTGFtY)
* [_Summary_](https://www.youtube.com/watch?v=3Zt_NeA51gA)

---

### TOPIC 4 - Компютърни архитектури (Computer Architecture), Logical Gates, Latches, Flip-Flop, допълнителен код и др.

* [_Компютърни архитектури_](https://www.youtube.com/watch?v=TLPzUHXD9nc)
* [_Цифрово аналогов и аналогово цифров преобразувател_](https://www.youtube.com/watch?v=U1qNNjrHo80)
* [_Числа с плаваща запетя (Floating Point)_](https://www.youtube.com/watch?v=W0xTHX04GX8)

---

### TOPIC 5 - Асемблер, Регистри, Инструкции, Операнди

* [_Асемблер, Регистри, Инструкции, Операнди част 1/2_]()
* [_Асемблер, Регистри, Инструкции, Операнди част 2/2_]()
* [_x86 Assembly Guide_]()
* [_The code for the solutions_](https://pastebin.com/BDp2QJdk)

<br>

_In VS 2017 -> empty C++ project -> add file C++ Source.cpp -> Ctrl + F5_

_Instructions:_

|Symbol| C++ Assembly Operands Name                              | /   |/    |
|-----|-------------------------------------------|---------------------|-------------|
| =  |Mov      |2     |Move|
| +=  |Add      |2     |Add|
| -=  |Sub      |2     |Subtract|
| *=  |Mul      |1     |Multiply (unsigned)|
| *=  |iMul      |1, 2, 3     |Multiply (signed)|
| /=  |Div      |1     |Divide (unsigned)|
| /=  |iDiv      |1     |Divide (signed)|
| ++  |Inc      |1     |Increment|
| --  |Dec      |1     |Decrement|
| >>= |Shr      |2     |Shift Right (unsigned)|
| >>= |Sar      |2     |Shift Arithmetic right (signed)|
| <<= |Shl      |2     |Shift Left|
| &=  |And      |2     |Bit And|
| ^=  |Xor      |2     |Bit XOR|
| ~=  |Not      |1     |Bit not|
| -  |Neg      |1     |negate|

<br>

**Registry:**

The registry is a special memory located right in the processor. 
Working with them is therefore much faster than memory. 
The processor stores there values that it is working with.

1. Data registers - are of general use (are universal), the following are their required uses in some operations, 
32-bit, the lower 16 bits can be accessed under the name without E, 
and this 16-bit part can still be divided into half by eight bit, 
the lower eight bits indicate the name ending in L, the top ending the name H. 
The top 16 bits of the entire 32-bit register can not be directly addressed (not accessible via a name). 
E.g. EAX is a 32-bit register, the lower 16 bit can be accessed under the name AX, 
and from these 16 bits the lower 8 is called the AL register, the top AH.

- EAX, AX, AH, AL (Accumulator) - multiplier and splitter, I / O operations
- EBX, BX, BH, BL (Base) - indirect memory addressing
- ECX, CX, CH, CL (Counter) - Cycle, Shift and Rotation Counter
- EDX, DX, DH, DL (Data) - indirect input / output addressing

2. Pointers and index registers - used to place the address, 
32-bit, lower 16 bits denotes a name without E and can not be subdivided (unlike previous universal registers):

- EBP, BP (Base Pointer) - base register, addressing function parameters and local variables on the stack 
(bottom of the stack), it is not reasonable to change it arbitrarily
- ESP, SP (Stack Pointer) - pointer to stack top (stack top address), this also is not wise to change arbitrarily
- EDI, DI (Destination Index) - destination address
- ESI, SI (Source Index) - source address
- EIP, IP (Instruction Pointer) - the pointer to the current program location, 
the instruction address next to the instruction being executed, can not be changed directly 
(only with the appropriate instructions)

<br>

**Numerical operations:**

* INC destination - to "destination" add one (register, memory)
* DEC destination - subtract one from destination (register, memory)
*ADD destination, source - add source to destination (register - value, memory - value, register - register, memory - register, register - memory)
* SUB destination, source -  subtract source from destination (register - value, memory - value, register - register, memory - register, register - memory)
* NEG destination - turn the sign in destination (register, memory)
* MUL source - the AL register multiplies with the source (eight-bit register or memory) and writes the result to the AX register (eight-bit multiplication).
* MUL source - AX multiplies with source (sixteen bit register or memory) and writes the result (32 bits) to the DX, AX register pair (sixteen bit multiplication).
* MUL source - The EAX register is multiplied by the source (32-bit register or memory) and the result (64 bits) is written to the EDX, EAX register pair (32-bit multiplication).
* IMUL source - like MUL, but multiplication with sign
* IMUL source, constant - like IMUL, the source is multiplied by the constant and stored in the source
* IMUL destination, source - signed multiply target and source (16.32-bit register - 16.32-bit register, 16.32-bit register - memory)
* IMUL destination, source, constant - move to destination, source multiplied by constant (16.32-bit register - 16.32-bit register - value, 16.32-bit register - memory - value)
* DIV source - the AX register divide by source (8-bit register or memory) and the share is stored in AL, the remainder is divided into AH (eight-bit division)
* DIV source - double-bit in DX, AX registers source divide by source (16-bit register or memory) and share in AX, the remainder is stored into DX (sixteen-bit division)
* DIV source - 8 bytes in the EDX, EAX divide by source (32 bit register or memory), and the share is stored in EAX, the remainder is stored into EDX (thirty-bit division)
* IDIV source - like DIV but sign division

---

### TOPIC 6 - Асемблер, "Типове данни" - няма, Conditional Jumps

* [_Асемблер, "Типове данни" - няма, Conditional Jumps 1/2_](https://www.youtube.com/watch?v=L9U7BllgSso)
* [_Асемблер, "Типове данни" - няма, Conditional Jumps 1/2_](https://www.youtube.com/watch?v=Sx9kK0kkA8c)
* [_The code for the solutions_](https://www.youtube.com/watch?v=Sx9kK0kkA8c)

<br>

_In VS 2017 -> empty C++ project -> add file C++ Source.cpp -> Ctrl + F5_

|C++| Assembly                              | Note   |
|-----|-------------------------------------------|---------------------|
| //  |;      |Comment     |
| Goto  |Jmp      | Jump    |
| Label: |Label:      |     |
| &  |Offset      | Reference (address of variable)    |
| *  |[]      | Dereference (address of variable) |
| (char)&  |Byte ptr      |Hard conversion to 1 byte     |
| (short)&  |Word ptr      |Hard conversion to 2 byte     |
| (int)&  |Dword ptr      |Hard conversion to 4 byte     |

<br>

**Registry:**

The registry is a special memory located right in the processor. 
Working with them is therefore much faster than memory. 
The processor stores there values that it is working with.

1. Data registers - are of general use (are universal), the following are their required uses in some operations, 
32-bit, the lower 16 bits can be accessed under the name without E, 
and this 16-bit part can still be divided into half by eight bit, 
the lower eight bits indicate the name ending in L, the top ending the name H. 
The top 16 bits of the entire 32-bit register can not be directly addressed (not accessible via a name). 
E.g. EAX is a 32-bit register, the lower 16 bit can be accessed under the name AX, 
and from these 16 bits the lower 8 is called the AL register, the top AH.

- EAX, AX, AH, AL (Accumulator) - multiplier and splitter, I / O operations
- EBX, BX, BH, BL (Base) - indirect memory addressing
- ECX, CX, CH, CL (Counter) - Cycle, Shift and Rotation Counter
- EDX, DX, DH, DL (Data) - indirect input / output addressing

2. Pointers and index registers - used to place the address, 
32-bit, lower 16 bits denotes a name without E and can not be subdivided (unlike previous universal registers):

- EBP, BP (Base Pointer) - base register, addressing function parameters and local variables on the stack 
(bottom of the stack), it is not reasonable to change it arbitrarily
- ESP, SP (Stack Pointer) - pointer to stack top (stack top address), this also is not wise to change arbitrarily
- EDI, DI (Destination Index) - destination address
- ESI, SI (Source Index) - source address
- EIP, IP (Instruction Pointer) - the pointer to the current program location, 
the instruction address next to the instruction being executed, can not be changed directly 
(only with the appropriate instructions)
 
<br>

**Convert between data types**

Narrowing to a smaller type is done regardless of whether the number is either unsigned or not. We will use either a smaller part of the register, or if we use the memory, we will use the ptr operator

<br>

```c++
int main () {
    char p1;
    short p2;
    int p4 = 0xdeadbeef;
    _asm {
        mov ebx, 0xdeadbeef
        mov p1, bl
        mov p2, bx
        mov byte ptr p2, 2
        mov byte ptr p4, 2
        mov eax, word ptr p4
    }
}
```

<br>

When expanding a value from a smaller type to a larger value for unsigned values, we add zeroes to the newly added positions:

* mov eax, 0
* mov al, bl

Alternatively, we can use movzx, which is a variation of mov and allows the second operand to be smaller than the first.
When expanding a value from a smaller type to a larger value for a signed value, we add the highest bit value to the newly added positions. For this purpose, movsx operations are performed.
We can use the following operations when divide, these will take carre of expanding the value:

* cbw - spreads al-> ax
* cwd - spreads ax-> dx: ax
* cdq - extend eax-> edx: eax
* cwde - spreads ax-> eax

Try: transfers between different values.

**Conditional and unconditional jumps**
Label: indicates a memory location (code). It is written in the form: label:
Unconditional jump: jmp place - performs an unconditional jump to a part of the code with the label place

**Jump conditional code (jcc)**

This is a jump conditioned by state of one or more eflags bits. Only in this way is it possible to perform a direct branch of the program in Assembler. Therefore, before instructing conditional jump, we always instruct (e.g., CMP, TEST, etc.) to set the flag used. If the jump condition is not met, the program continues as if the jump instructions were not at all here. The conditional jump instructions always start with the letter J. Behind it is the abbreviation indicating on which bits of the eflags register the jump is dependent.

<br>

* JE / JZ label - jump, if equal, ZF = 1
* JNE / JNZ Label - jump, if not equal, ZF = 0
* JS label - jump, if sign, SF = 1
* JNS Label - jump, if not a sign, SF = 0
* JO label - jump, if overflow, OF = 1
* JNO label - jump, if not overflow, OF = 0
* JP / JPE label - jump if parity is equal, PF = 1
* JNP / JPO label - jump, if odd parity, PF = 0
* Jumps after an incomparable comparison:
* JA / JNBE label - jump, if larger (CF = 0) AND (ZF = 0)
* JAE / JNB / JNC Jump Label - jump, if larger or equal, CF = 0
* JB / JNAE / JC label - jump, if smaller, CF = 1
* JBE / JNA label - jump if less than or equal to (CF = 1) OR (ZF = 1)
* Jumps after sign comparison:
* JG / JNLE label - jump, if larger, (SF = OF) AND (ZF = 0)
* JGE / JNL label - jump, if larger or equal, SF = OF
* JL / JNGE label - jump, if smaller, SF <> OF
* JLE / JNG label - Jump if less than or equal to (SF <> OF) OR (ZF = 1)

<br>

```c++
int abs (int a) {
    int i;
    _asm {
        mov eax, a
        cmp eax, 0
        jge end
        neg eax
end:
        mov i, eax
    }
    return i;
}
```

---

### TOPIC 7 - Асемблер, адресиране на памет, флагове, условни конструкции, цикли

* [_Асемблер, адресиране на памет, флагове, условни конструкции, цикли_](https://www.youtube.com/watch?v=WogVkII0LxM)
* [_The code for the solutions_](https://pastebin.com/ZwF8bEQ3)

<br>

Memory Access:

**Memory Addressing**
The memory location indicates the value (address, directly or in the registry) that must be written in square brackets.

**Attention!** In one instruction, you can only address memory once. This means that, for example, the command a = 33; you write normally as mov a, 33, but vice versa a = b; so simply can not write. There would be two addresses in one instruction.

_Question: What instructions do a = b?_

Assembler allows two addressing methods.

**Direct address**
Direct addressing is where the addresses are known directly during translation, that is, when working with static or global variables (C language).

MOV AH, [0x04F01A50] - forward the 8-bit AH register from the address specified by the number
We will use this method if we know the address of the memory location in advance.

```c++
static int thevar, thevar2; // variables thevar and thevar2 are in memory
_asm {
    mov eax, thevar; eax = thevar - enter the 32-bit memory value in the eax register.
    mov eax, thevar + 4; eax = thevar + 4 = thevar2 - enter the eax register 32-bit value from the thevar + 4 = thevar2
}
```

The name of the static variable is then evaluated as a direct address (because the translator knows the address of the value of the variable in the memory), it is only a text mark of the address of the value of the variable. The MOV instruction ax, thevar is overwritten to MOV ax, [address_value_variable]. With variables as addresses, we can still perform basic arithmetic operations.

```c++
_asm {
    mov ax, thevar; ax = [address_value_thevar]
    mov ax, [thevar]; ax = [[address_value_thevar]] = [address_value_thevar]
}
```

If the thevar is a static or global variable, then both commands do the same, so the thevar variable is assigned to AX.

**Indirect address**

In C (C ++), this addressing matches the pointers to values. While in direct addressing we know the exact address of the value of the variable already in translation, in indirect addressing we have this variable value address in another variable of the type of pointer to the value, so value of the pointer (for example byte size) is address (32bit) of this value (byte size) in memory. The general shape of the inverse address is [mem + reg1 + reg2 * size] (the equivalent is mem [reg1] [reg2 * size]), where size is constant (can only 1, 2, 4, 8) reg1, reg2 arbitrary 32-bit registers and mem is the direct addressing of the memory (some number), all items are optional.

```c++
char * thepointer; // 32-bit pointer variable to 8-bit value
_asm {
    mov ebx, thepointer; ebx = thepointer - direct addressing
    mov esi, 2; esi = 2
    mov al, [ebx + esi]; al = * (thepointer + 2) = thepointer [2] - indirect addressing
}
```

**Reference and dereference**

If only the names are specified in the instructions, the compiler must always convert it into a suitable shape because the name of variable itself in assembly does not mean anything. Each name entry is translated to the shape ptr name or offset name, which corresponds to the dereference and reference in C language. Except for jump instructions or function calls, the ptr instruction is used.


**Instructions lea**

The address calculation is performed during instruction decoding phase. This is the fastest possible calculation. Instruction lea allows you to efficiently calculate memory address space. This instruction can also be used for quick multiplication. E.g. multiplication of nine:

```
mov eax, a
lea eax, [eax + 8 * eax]
```

**Conditional Jumps:**

|Instruction|Flags|Description|
|-----|-------------------------------------------|---------------------|
|Ja/jnbe|(CF or ZF) = 0|Greater/smaller of equal to|
|Jae/jnb|CF = 0|Greater or equal/ not smaller|
|Jb/jnae|CF = 1|Smaller / not bigger or equal|
|Jbe/jna|(CF or ZF) = 1|Smaller or equal/ not Bigger|
|Jc|CF = 1|Carry|
|Jnc|CF = 0|Not Carry|
|Jz/je|ZF = 1|Zero / Equal|
|Jnz/jne|ZF = 0|Not zero / Not equal|
|Jnp/jpo|PF = 0|Not parity / parity odd|
|Jp/jpe|PF = 1|Parity / parity even|
|Jcxz|cx = 0|Register cx = 0|
|Jecxz|ecx = 0|Register ecx = 0|

<br>

**Signed Conditional Jumps:**

|Instruction|Flags|Description|
|-----|-------------------------------------------|---------------------|
|Jg/jnle|((SF xor OF) or ZF) = 0|Greater/ not Smaller or equal|
|Jge/jnl|(SF xor OF) = 0|Greater or equal/ not smaller|
|Jl/jnge|(SF xor OF) = 1|Smaller / not bigger or equal|
|Jle/jng|((SF xor OF) or ZF) = 0|Smaller or equal/ not Bigger|
|Jno|OF = 0|Not overflow|
|Jo|OF = 1|overflow|
|Js|SF = 1|Is negative|
|Jns|SF = 0|Is positive|

---

### TOPIC 8 - Асемблер, Стек, Подпрограми, Рекурсия

* [_Асемблер, Стек, Подпрограми, Рекурсия, група 1_](https://www.youtube.com/watch?v=05M6g-MwX8g)
* [_Асемблер, Стек, Подпрограми, Рекурсия, група 2_](https://www.youtube.com/watch?v=umLkb_M_Nts)
* [_The code for the solutions_](https://pastebin.com/73miY0qP)

<br>

**Calling subroutines**

The use of the Embedded Assembler is mainly in the subroutine implementation. First, we need to show how subroutines are called.

Subroutine call is to store parameters into the stack and change the address in register EIP (counter instructions) to the address of the subroutine,also we store current address of where you make the call (for the processor to know where to return). The parameters are stored in the stack, the rest will be set by the CALL instruction.

<br>

**Storing parameters in stack**

In the procedure header (or function), we almost always find definition of 

Parameters called by:

* value - the subprogram only uses them
* link - a subprogram can read and write to them

For example, a ``void sum (short a, short b, short * c);``  is a declaration of a procedure named sum with parameters a, b called by value and c called by link. When you call this procedure from some parts of the program written in C, to a and b is stored some values (or variables, but subroutine does not change these), and c is set to address (or a variable of type pointer).

From the place of the call, we pass the parameters to the subroutines always via the stack and in the reverse order of the subroutine declaration (so the first parameter is at the top of the stack).
When we call by value, we store specific values (can be read from memory). Due to the organization of the stack, the parameters called by the value are stored in dword as follows:

* parameters of one byte (char, unsigned char) - occupy the entire dword, unused bits will be zero
* word parameters (short, unsigned short) - occupy the entire dword, unused bits will be zero
* dword parameters (long, unsigned long, float, pointer) - occupies dword
* parameters longer (strings, fields, structures) - their address (pointer)

<br>

**Subroutine call itself**
The EIP registers change when the call is made. Jump to the subroutine provides instructions:

* CALL address - store the content of EIP at the top of the stack and fill this register with the address specified in the parameter (in the C language the subroutine name is directly evaluated to some address)

Subroutine calls are simple. We simply write a CALL instruction with the subroutine name (procedures or function). Before entering the subroutine, we have stored the subroutine parameters in the stack, so after leaving the subroutine, we must not forget to remove these parameters from the stack !

Example:

```c++
#include <stdio.h>
 
void factorial_iter (unsigned char a, unsigned long * b)
{
    if (a <= 1) return;
    *b *= a;
    factorial_iter (a - 1, b);
}
 
unsigned long factorial (unsigned char a)
{
    unsigned long ret = 1, *pret = &ret;
    _asm {
        push dword ptr pret
        push dword ptr a
        call factorial_iter
        add esp, 8
    }
    return ret;
}
 
int main ()
{
    printf ("% u! =% lu \ n", 10, factorial (10));
    return 0;
}
```

    The same sequence of instructions as the Assembler block in this program performs one line in C: factorial_iter (a, pret);

<br>

**Returns value from function**

The function is a subprogram that returns one value of the type specified in the declaration. We return the returned value after returning from the function always in the registers:

* AL - Functional value of byte size
* AX - word size function value
* EAX - the value of dword size, ie the address (e.g., strings)

<br>

**Enter the subroutine**

All subroutines must have the same conditions for executing their code and for accessing local variables within the subroutine,that means must "have its stack". However, the program stack is only one, so that is why every subroutine have defined space on stack, and this space corresponds with local variables of subroutine. The space in memory where stack is, is defined by EBP and ESP registers, EBP points to the top of stack when subroutine is called (new bottom of stack) and ESP is set to the address right behind local variables (new top of stack), that means CALL instruction automaticly does:

```
PUSH EBP
MOV EBP, ESP
SUB ESP, local_variables
```

Now using register EBP we can access :

* parameters- adding to value stored in EBP,  because they are "in front of stack " (for example [EBP + 8] is address of first parameter)
* local variables- subtracting from value in EBP, because they are "in stack" (for example [EBP - 4] is address of first local variable of type long int)

<br>

**Subroutine end**

Before ending of soubroutine the stack of caller must be set to previous phase ( to phase before call). Registers EBP and ESP are automaticly restored to values right before subroutine call like this:

```
MOV ESP, EBP
POP EBP    
```

or using instruction LEAVE.

The end of soubroutine (return to caller part of code) is automaticly managed by:

* RET -take address from top of stack and move it to EIP, very important without ret, processor continues with next instruction

**Important!** Actions that instruction ENTER, LEAVE and RET does, are in inline assembly automaticly executed thanks to compilor. That is why we cannot explicitly execute them !

<br>

**Registers Usage**

All functions are sharing same set of registers, and that can be a problem. for example if we want the value in some register to be same even after calling soubroutine which is using this register. That is why this convention is used :

* for register EAX, ECX, EDX is responsible calling function. That means if we want the value to be same after function call we need to store this value somewhere before function call, after function return in these registers can be any value.
* for registers EBX, ESI, EDI is responsible called function. That means. If we want to use any of these registers we need to store it's value to stack and then before returning we need to set this value back. After function call there should be same value !



* [__]()
