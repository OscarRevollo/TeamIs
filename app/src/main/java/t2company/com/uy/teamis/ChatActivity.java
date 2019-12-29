package t2company.com.uy.teamis;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

import t2company.com.uy.teamis.Adapter.UserAdapter;
import t2company.com.uy.teamis.Model.Chat;
import t2company.com.uy.teamis.Model.User;

public class ChatActivity extends AppCompatActivity {
    DatabaseReference reference;
    private RecyclerView recyclerView;

    private UserAdapter userAdapter;
    private List<User> mUsers;
    FirebaseUser fuser;
    private List<String> userList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat);

        recyclerView=findViewById(R.id.recycler_view);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(ChatActivity.this));
        fuser = FirebaseAuth.getInstance().getCurrentUser();
        userList = new ArrayList<>();
        reference = FirebaseDatabase.getInstance().getReference("Chats");
        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                userList.clear();
                for (DataSnapshot snapshot : dataSnapshot.getChildren()){
                    Chat chat =snapshot.getValue(Chat.class);
                    if (chat.getSender().equals(fuser.getUid())){
                        userList.add(chat.getReceiver());
                    }
                    if (chat.getReceiver().equals(fuser.getUid())){
                        userList.add(chat.getSender());
                    }
                }
                readChats();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

    }

    private void readChats(){
        mUsers=new ArrayList<>();

        reference= FirebaseDatabase.getInstance().getReference("Users");

        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                mUsers.clear();
                for (DataSnapshot snapshot : dataSnapshot.getChildren()){
                    User user = snapshot.getValue(User.class);

                    //muestra un usuario en chat
                    for (String id : userList){
                        if (user.getId().equals(id)){
                            if (mUsers.size()!= 0 ){
                                if(!exist(user,mUsers)){
                                    mUsers.add(user);
                                }
                            }else {
                                mUsers.add(user);
                            }
                        }
                    }
                }

                userAdapter = new UserAdapter(ChatActivity.this,ordenar(mUsers,userList));
                recyclerView.setAdapter(userAdapter);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }
    private List<User> ordenar(List<User> mUsers, List<String> userList){
        List<User> ordenado=new ArrayList<>();
        for(int i=userList.size()-1;i>-1;i--){
            for (User user1 : mUsers){
                if (!exist(user1,ordenado)) {
                    if (userList.get(i).equals(user1.getId())) {
                        ordenado.add(user1);
                    }
                }
            }

        }
        return ordenado;
    }
    private boolean exist(User user,List<User> mUsers){
        boolean resp=false;
        for (User user1 : mUsers){
            if (user.getId().equals(user1.getId())){
                resp=true;
            }

        }

        return resp;
    }

}