import SwiftUI
import Shared

import KMPNativeCoroutinesAsync
import KMPNativeCoroutinesCore

struct ContentView: View {
    @ObservedObject private(set) var viewModel: ContentViewModel

    var body: some View {
        List(viewModel.meals, id: \.self) { meal in
            HStack(spacing: 16) {
                Image(systemName: "")
                    .frame(width: 60, height: 60)

                VStack(alignment: .leading, spacing: 2) {
                    Text(meal.name)
                        .font(.system(size: 16))
                }
            }
        }
        .task { await self.viewModel.startObserving() }
    }
}

#Preview {
    ContentView(viewModel: ContentViewModel())
}
