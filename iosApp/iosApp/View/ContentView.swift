import SwiftUI
import Shared

import KMPNativeCoroutinesAsync
import KMPNativeCoroutinesCore

struct ContentView: View {
    @ObservedObject private(set) var viewModel: ContentViewModel

    var body: some View {
        List(viewModel.meals, id: \.self) { meal in
            mealCell(meal: meal)
        }
        .task {
            await self.viewModel.startObserving()
        }
    }

    func mealCell(meal: DishModel) -> some View {
        HStack(spacing: 16) {
            AsyncImage(url: URL(string: meal.thumbnailString)) { image in
                image.resizable()
                    .aspectRatio(contentMode: .fill)
            } placeholder: {
                ProgressView()
            }
            .frame(width: 100, height: 100)
            .clipShape(RoundedRectangle(cornerRadius: 8))

            VStack(alignment: .leading, spacing: 2) {
                Text(meal.name)
                    .font(.system(size: 16))
            }
        }
    }
}

#Preview {
    ContentView(viewModel: ContentViewModel())
}
