package pl.dmcs.pb.richchat.app.friends.list

import android.app.AlertDialog
import android.os.Bundle
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.firebase.ui.database.FirebaseRecyclerAdapter
import com.firebase.ui.database.FirebaseRecyclerOptions
import com.google.firebase.database.FirebaseDatabase
import kotlinx.android.synthetic.main.fragment_user_list.*
import pl.dmcs.pb.richchat.R
import pl.dmcs.pb.richchat.app.BasePresenter
import pl.dmcs.pb.richchat.app.chat.view.ChatActivity
import pl.dmcs.pb.richchat.app.chat.view.USER_KEY
import pl.dmcs.pb.richchat.data.entity.UserHandle
import javax.inject.Inject

class UserKeyNotProvided : Throwable()

class FriendListPresenter
@Inject
constructor(
    private val view: UserListFragment,
    private val firebaseDatabase: FirebaseDatabase
) :  UserListPresenter(view, firebaseDatabase) {
    override fun bindOnUserClickListener(model: UserHandle): View.OnClickListener? = View.OnClickListener {

    }

    override fun getUsersPath(): String = view.arguments?.getString(USER_KEY) ?: throw UserKeyNotProvided()

    private fun startChat(userId: UserHandle) {
        view.startActivity(ChatActivity.startChatWithUser(view.context!!, userId))
    }


}