# Basic math operations
.data
	message: .asciiz "\nDo you want to continue? (0/1)(No/Yes): "
	input1: .asciiz "input first number: "
	input2: .asciiz "input operation code: "
	input3: .asciiz "input second number: "
.text

# While loop
while:

	#Print "input first number"
	la $a0, input1	
	li $v0, 4
	syscall
	
	# Read first number
	li $v0, 5
	syscall
	move $s0, $v0
	
	#Print "input operation code"
	la $a0, input2	
	li $v0, 4
	syscall
		
	# Read operation's number
	li $v0, 5
	syscall
	move $s1, $v0
	
	#Print "input second number"
	la $a0, input3	
	li $v0, 4
	syscall
	
	# Read second number
	li $v0, 5
	syscall
	move $s2, $v0
	
	# Compare each op's number with input
	beq $s1, 0, addnum
	beq $s1, 1, subnum
	beq $s1, 2, divnum
	beq $s1, 3, mulnum

# Multiply nums
mulnum: 
	mul $a0, $s0, $s2
	j exit
	
# Divide nums
divnum:	
	div $a0, $s0, $s2 
	j exit
	
# Substract nums
subnum: 
	sub $a0, $s0, $s2
	j exit

# Add two nums
addnum:	
	add $a0, $s0, $s2
	j exit
	
# Use exit to stop program
exit:
	# Print result
	li $v0, 1
	syscall	
	
	# Write 'do you want to continue?'
	li $v0, 4
	la $a0, message
	syscall
	
	# Read user's response
	li $v0, 5
	syscall
	
	# Check if user want to continue
	# If not then stop program
	beq $v0, 1, while
	
	li $v0, 10
	syscall
	
