package diskord.example.js

import com.jessecorbett.diskord.dsl.bot
import com.jessecorbett.diskord.dsl.command
import com.jessecorbett.diskord.dsl.commands
import kotlinx.coroutines.coroutineScope

const val BOT_TOKEN = "bot-token"

suspend fun main(): Unit = coroutineScope {
    bot(BOT_TOKEN) {
        commands {
            command("ping") {
                reply("pong")
                delete()
            }
        }
    }

    return@coroutineScope
}
