package team.phantompanthers.opcodes.player

import com.qualcomm.robotcore.hardware.Gamepad
import team.phantompanthers.opcodes.OpCodeBase

abstract class PlayerOpCodeBase : OpCodeBase() {
    val currentController = controllerSwitchCheck()
    private fun controllerSwitchCheck(): String {
        return when {
            isGamePadActive(gamepad1) -> "Gamepad 1 is being used"
            isGamePadActive(gamepad2) -> "Gamepad 2 is being used"
            else -> "No Controller Activity Detected"
        }
    }
    private fun isGamePadActive(gamePad: Gamepad): Boolean {
        return gamePad.a || gamePad.b || gamePad.x || gamePad.y ||
                gamepad1.dpad_up || gamepad1.dpad_down || gamepad1.dpad_left || gamepad1.dpad_right ||
                gamepad2.dpad_up || gamepad2.dpad_down || gamepad2.dpad_left || gamepad2.dpad_right ||
                gamepad1.left_bumper || gamepad1.right_bumper || gamepad2.left_bumper || gamepad2.right_bumper
    }
}
