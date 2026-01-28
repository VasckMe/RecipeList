//
// Created by Anton Kasarin on 26/01/2026.
//

import SwiftUI
import Shared

struct MealDetailsView: View {
    @ObservedObject private(set) var viewModel: MealDetailsViewModel

    var body: some View {
        ScrollView {
            VStack(spacing: 10) {
                AsyncImage(url: URL(string: viewModel.detailsModel?.thumbnailString ?? "")) { image in
                    image.resizable()
                        .aspectRatio(contentMode: .fit)
                } placeholder: {
                    ProgressView()
                }
                .frame(width: 300, height: 300)
                .clipShape(RoundedRectangle(cornerRadius: 10))

                Text(viewModel.detailsModel?.name ?? "")
                    .font(.title)
                    .bold()
                Text(viewModel.detailsModel?.category ?? "")
                Text(viewModel.detailsModel?.instructions ?? "")
            }
            .padding()
            .task {
                await self.viewModel.fetchDetails()
            }
        }
    }
}