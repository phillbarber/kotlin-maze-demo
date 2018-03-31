package demo

val superSimpleSolvableMaze = """
####################
#                  #
#    S             #
#                  #
#                  #
#                  #
#                  #
#                  #
#                  #
#                  #
#                  #
#    F             #
#                  #
#                  #
#                  #
#                  #
#                  #
#                  #
#                  #
#                  #
#                  #
#                  #
#                  #
#                  #
####################""".removeFirstCharacter()


val expectedSuperSimpleSolvableMazeWithRoute = """
####################
#                  #
#    S             #
#    .             #
#    .             #
#    .             #
#    .             #
#    .             #
#    .             #
#    .             #
#    .             #
#    F             #
#                  #
#                  #
#                  #
#                  #
#                  #
#                  #
#                  #
#                  #
#                  #
#                  #
#                  #
#                  #
####################
""".removeFirstCharacter()

val simpleSolvableMaze = """
############################################
#S                 #                       #
#                  #                       #
#                  #                       #
#                  #                       #
#                  #                       #
#                  #                       #
#                  #                       #
#                  #                       #
#                  #                       #
#                  #                       #
#                  #                       #
#                  #                       #
#                  #                       #
#                  #                       #
#                  #                       #
#                  #                       #
#                  #                       #
#            F     #                       #
#                  #                       #
#                                          #
#                  #                       #
#                  #                       #
#                  #                       #
############################################""".removeFirstCharacter()

val mazeWithANarrowWall="""
############################################
#                  #                       #
#                  #                       #
#                  #                       #
#                  #                       #
#                  #                       #
#                  #                       #
#                  #                       #
#                  #         F             #
#                  #                       #
#                  #                       #
#                  #                       #
#    S             #                       #
#                  #                       #
#                  #                       #
#                                          #
#                  #                       #
#                  #                       #
#                  #                       #
############################################""".removeFirstCharacter()


val maze = """
##########
# S  F   #
##########""".removeFirstCharacter()

fun String.removeFirstCharacter(): String{
    return this.substring(1, this.length);
}
