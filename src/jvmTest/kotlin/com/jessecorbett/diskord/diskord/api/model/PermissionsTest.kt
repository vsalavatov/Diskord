package com.jessecorbett.diskord.diskord.api.model

import assertk.assertThat
import assertk.assertions.isFalse
import assertk.assertions.isTrue
import com.jessecorbett.diskord.api.model.Permission
import com.jessecorbett.diskord.api.model.Permissions
import kotlin.test.Test

class PermissionsTest {
    @Test
    fun `administrator_should_have_all_permissions`() {
        val permissions =
            Permissions.of(Permission.ADMINISTRATOR)

        assertThat(Permission.ADMINISTRATOR in permissions).isTrue()
        assertThat(Permission.VIEW_AUDIT_LOG in permissions).isTrue()
        assertThat(Permission.MANAGE_CHANNELS in permissions).isTrue()
        assertThat(Permission.READ_MESSAGE_HISTORY in permissions).isTrue()
    }

    @Test
    fun `should_handle_roles_which_have_certain_permissions`() {
        val permissions = Permissions.of(
            Permission.READ_MESSAGE_HISTORY,
            Permission.KICK_MEMBERS
        )

        assertThat(Permission.READ_MESSAGE_HISTORY in permissions).isTrue()
        assertThat(Permission.KICK_MEMBERS in permissions).isTrue()
        assertThat(Permission.BAN_MEMBERS in permissions).isFalse()
    }

    @Test
    fun `should_handle_adding_permissions`() {
        var permissions = Permissions.of(Permission.ADD_REACTIONS) + Permissions.of(
            Permission.READ_MESSAGE_HISTORY
        )

        assertThat(Permission.ADD_REACTIONS in permissions).isTrue()
        assertThat(Permission.READ_MESSAGE_HISTORY in permissions).isTrue()
        assertThat(Permission.BAN_MEMBERS in permissions).isFalse()

        permissions += Permission.BAN_MEMBERS
        assertThat(Permission.BAN_MEMBERS in permissions).isTrue()
    }

    @Test
    fun `should_handle_removing_permissions`() {
        var permissions = Permissions.ALL
        Permission.values().forEach {
            assertThat(it in permissions).isTrue()
        }

        permissions -= Permissions.of(
            Permission.READ_MESSAGE_HISTORY,
            Permission.ADMINISTRATOR
        )
        Permission.values().forEach {
            if (it in arrayOf(
                    Permission.READ_MESSAGE_HISTORY,
                    Permission.ADMINISTRATOR
                )) {
                assertThat(it in permissions).isFalse()
            } else {
                assertThat(it in permissions).isTrue()
            }
        }

        permissions -= Permissions.of(Permission.SEND_MESSAGES)
        Permission.values().forEach {
            if (it in arrayOf(
                    Permission.SEND_MESSAGES,
                    Permission.READ_MESSAGE_HISTORY,
                    Permission.ADMINISTRATOR
                )) {
                assertThat(it in permissions).isFalse()
            } else {
                assertThat(it in permissions).isTrue()
            }
        }
    }
}
