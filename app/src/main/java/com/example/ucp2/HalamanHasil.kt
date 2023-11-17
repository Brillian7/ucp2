package com.example.ucp2

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Divider
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import com.example.ucp2.data.FormUIState
import java.text.Normalizer.Form

@Composable
fun HalamanDetail(
    orderUIState: FormUIState,
    onCancelButtonClicked: () -> Unit,
    modifier: Modifier = Modifier
) {
    val items = listOf(
        Pair(stringResource(R.string.nama), orderUIState.nama),
        Pair(stringResource(R.string.nim), orderUIState.nim),
        Pair(stringResource(R.string.konsentrasi), orderUIState.konsentrasi) ,
        Pair(stringResource(R.string.dosen), orderUIState.dosen)
    )
    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.SpaceBetween
    )
    {
        Column(
            modifier = Modifier.padding(dimensionResource(R.dimen.padding_medium)),
            verticalArrangement = Arrangement.spacedBy(dimensionResource(R.dimen.padding_small)) //ke samping
        ) {
            Text(text = "Nama Mahasiswa")
            Text(text = orderUIState.nama)
            Divider()


            Text(text = "NIM")
            Text(text = orderUIState.nim)
            Divider()


            Text(text = "Konsentrasi")
            Text(text = orderUIState.konsentrasi)
            Divider()

            Text(text = "Judul Skripsi")
            Text(text = orderUIState.judul)
            Divider()

            items.forEach { item ->
                Column {
                    Text(text = item.first.uppercase())
                    Text(text = item.second.toString(), fontWeight = FontWeight.Bold)
                }
                Divider(thickness = dimensionResource(R.dimen.thickness_divider))

                Spacer(modifier = Modifier.height(dimensionResource(R.dimen.padding_small)))
                Column(
                    modifier = Modifier
                        .weight(1f, false)
                        .padding(dimensionResource(R.dimen.padding_medium))
                ) {
                    
                    OutlinedButton(
                        modifier = Modifier.fillMaxWidth(),
                        onClick = onCancelButtonClicked
                    ) {
                        Text(stringResource(R.string.btn_back))
                    }
                }
            }
        }
    }
}